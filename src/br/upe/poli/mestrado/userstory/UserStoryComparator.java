package br.upe.poli.mestrado.userstory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.AttributeChange;
import org.eclipse.emf.compare.CompareFactory;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.eobject.ProximityEObjectMatcher;
import org.eclipse.emf.compare.match.eobject.ProximityEObjectMatcher.DistanceFunction;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import userstory.UserstoryPackage;
import userstory.actionVerb;
import userstory.end;
import userstory.means;
import userstory.role;
import userstory.spec;

public class UserStoryComparator {
	private static PrintStream log = null;
	public static final int SIMPLE = 0;
	public static final int DICE = 1;
	public static final int JACCARD = 2;
	private Vector<Double> endsMatching = new Vector<Double>();
	
	public UserStoryComparator(EPackage ePackage, String extension) {
		try {
			log = new PrintStream(new FileOutputStream("Comparacoes.txt"));			
		} catch (IOException e) {
			log = new PrintStream(System.out);
		}		
		
		/*if (ecorePath != null && ecorePath.endsWith(".ecore") && !ecorePath.startsWith("http://") 
				&& !ecorePath.endsWith("Ecore.ecore")) {
			URI metaURI = URI.createFileURI(ecorePath);
			if (!metaURI.isPlatform()) {
				metaURI = URI.createPlatformResourceURI(ecorePath, true);
			}
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				    "ecore", new EcoreResourceFactoryImpl());
			ResourceSet rs = new ResourceSetImpl();
			final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(EPackage.Registry.INSTANCE);
			rs.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
			Resource r = rs.getResource(metaURI, true);
			EObject eObject = r.getContents().get(0);
			if (eObject instanceof EPackage) {
			    EPackage p = (EPackage) eObject;*/
		EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);	
		if (extension != null && !extension.equals("")) {
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(extension, new XMIResourceFactoryImpl());
		} else {
			System.out.println("Extensao invalida.");
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {		
		String[] uris = new String[53];
		double threshold = 0.8;
		UserStoryComparator comparator = new UserStoryComparator(UserstoryPackage.eINSTANCE, UserstoryPackage.eNAME);
		Map<String,Integer> weights = new HashMap<String,Integer> ();
		//weights.put("means", new Integer(4));
		//weights.put("end", new Integer(3));
		weights.put("verb", new Integer(2));
		
		for (int i = 0; i < uris.length; i = i + 1) {
			uris[i] = "userstories/us"+ (i + 1) + ".userstory";			 
		}
		for (int i = 0; i < uris.length; i = i + 1) {						
			for (int j = i + 1; j < uris.length; j = j + 1) {				
				
				double similaridade = comparator.calculateSimilarity(uris[i], uris[j], weights, 0, 0.3);
				if (similaridade > threshold) {
					System.out.println("Similaridade entre us" + (i+1) + " e us" + (j+1) + ": " + similaridade);
				}
			}
		}			
	}
	
	public double calculateSimilarity(String uri1, String uri2, Map<String,Integer> weights, int similarityFormula, final double proximityThreshold) {
		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();		
		resourceSet1.getResource(URI.createFileURI(uri1), true);		
		resourceSet2.getResource(URI.createFileURI(uri2), true);
		boolean roleChanged = false;
		boolean meansChanged = false;
		boolean verbChanged = false;
		int endsChanged = 0;
		Map<String,Double> matches = new HashMap<String,Double>();
		endsMatching.clear();
		DistanceFunction function = new DistanceFunction() {
			@Override
			public double distance(Comparison inProgress, EObject a, EObject b) {
				double distance = 1.0;
				String value1 = valueOf(a).toString();
				String value2 = valueOf(b).toString();				
				
				if (a instanceof spec && b instanceof spec) {
					distance = 0.0;
				} else {					
					distance = diceDistance(value1, value2);					
				}
				return distance;
			}			

			@Override
			public boolean areIdentic(Comparison inProgress, EObject a, EObject b) {
				double maxDistance = 0.0;
				
				if (proximityThreshold > 0.0 && proximityThreshold < 1.0) {
					maxDistance = 1 - proximityThreshold;
				} 
				
				return distance(inProgress, a, b) <= maxDistance;
			}			
		};
		IEObjectMatcher matcher = new ProximityEObjectMatcher(function);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());		 
		IMatchEngine.Factory.Registry registry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
		final MatchEngineFactoryImpl matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
		matchEngineFactory.setRanking(20); // default engine ranking is 10, must be higher to override.
		registry.add(matchEngineFactory);
		IComparisonScope scope = new DefaultComparisonScope(resourceSet1, resourceSet2, null);		
		//Comparison comparison = EMFCompare.builder().build().compare(scope);
		Comparison comparison = EMFCompare.builder().setMatchEngineFactoryRegistry(registry).build().compare(scope);
		List<Diff> differences = comparison.getDifferences();
		List<Diff> changes = changeComplements(differences);
		changes = filterDifferences(differences, proximityThreshold); 
		weights = verifyWeights(weights);		
		//TODO validar modelo
				
		for (Diff diff : changes) {
			String name = null;
			if (diff instanceof ReferenceChange) {
				EReference reference = ((ReferenceChange) diff).getReference();
				name = reference.getName();				
			} else if (diff instanceof AttributeChange) {
				EAttribute attribute = ((AttributeChange) diff).getAttribute();
				name = attribute.getEContainingClass().getName();
								
			}
			if (name.equals("actionVerb")) {
				name = "verb";
			}
			
			if (name.equals("role")) {
				roleChanged = true;
			} else if (name.equals("means")) {
				meansChanged = true;
			} else if (name.equals("verb")) {
				verbChanged = true;
			} else if (name.equals("end") && !diff.getKind().toString().equals("MOVE")) {				
				endsChanged = endsChanged + 1;
			}
			
			String kind = diff.getKind().toString();
			if (kind.equals("ADD")) {
				log.append("Inclusao do Atributo " + name + "\n");
			} else if (kind.equals("DELETE")) {
				log.append("Exclusao do Atributo " + name + "\n");
			} else if (kind.equals("MOVE")) {				
				log.append("Movimento do Atributo " + name + "\n");
			} else if (kind.equals("CHANGE")) {
				log.append("Mudanca do Atributo " + name + "\n");				
			} else {
				log.append("Mudanca nao prevista: " + diff + "\n");
			}
		}
		
		if (!roleChanged) {
			String role1 = getValue(uri1, "role");
			String role2 = getValue(uri2, "role");
			if (role1.equals(role2)) {
				log.append("Mesmo Role: " + role1 + "\n");
				matches.put("role", new Double(1.0));
			} else {
				double proximity = 1 - diceDistance(role1, role2);
				log.append("Roles similares(" + proximity + "): " + role1 + " e " + role2 + "\n");
				matches.put("role", new Double(proximity));
			}
		}
		if (!meansChanged) {
			String means1 = getValue(uri1, "means");
			String means2 = getValue(uri2, "means");
			if (means1.equals(means2)) {
				log.append("Mesmo Means: " + means1 + "\n");
				matches.put("means", new Double(1.0));
			} else {
				double proximity = 1 - diceDistance(means1, means2);
				log.append("Means similares(" + proximity + "): " + means1 + " e " + means2 + "\n");
				matches.put("means", new Double(proximity));
			}				
		}
		if (!verbChanged) {								
			String verb1 = getValue(uri1, "verb");
			String verb2 = getValue(uri2, "verb");
				if (verb1 != null && verb2 != null) {
				if (verb1.equals(verb2)) {
					log.append("Mesmo Verb: " + verb1 + "\n");
					matches.put("verb", new Double(1.0));
				} else {
					double proximity = 1 - diceDistance(verb1, verb2);
					log.append("Verbs similares(" + proximity + "): " + verb1 + " e " + verb2 + "\n");
					matches.put("verb", new Double(proximity));
				}
			}
		}
		Map<String,Integer> firstAmounts = new HashMap<String,Integer>();
		Map<String,Integer> secondAmounts = new HashMap<String,Integer>();		
		firstAmounts.put("role", new Integer(1));
		secondAmounts.put("role", new Integer(1));
		firstAmounts.put("means", new Integer(1));
		secondAmounts.put("means", new Integer(1));
		if (getValue(uri1, "verb") != null) {
			firstAmounts.put("verb", new Integer(1));
		}
		if (getValue(uri2, "verb") != null) {
			secondAmounts.put("verb", new Integer(1));
		}
		firstAmounts.put("end", new Integer(getValues(uri1, "end").size()));
		log.append("Ends da primeira estoria: " + firstAmounts.get("end") + "\n");
		secondAmounts.put("end", getValues(uri2, "end").size());
		log.append("Ends da segunda estoria: " + secondAmounts.get("end") + "\n");
		int higherAmountOfEnds = Math.max(firstAmounts.get("end").intValue(), secondAmounts.get("end").intValue());
		int endsNoChanged = higherAmountOfEnds - endsChanged - endsMatching.size();
		double endsWeight = (double) endsNoChanged;
		for (Double proximity : endsMatching) {
			endsWeight = endsWeight + proximity.doubleValue();
		}
		matches.put("end", new Double(endsWeight));
		log.append("Ends iguais: " + (endsNoChanged + endsMatching.size()) + "\n");
		double similarity = 0.0;
		switch(similarityFormula) {
			case DICE:
				similarity = diceCoefficient(matches, firstAmounts, secondAmounts, weights);
				break;
			case JACCARD:
				similarity = jaccardIndex(matches, firstAmounts, secondAmounts, weights);
				break;
			case SIMPLE:
				if(higherAmountOfEnds == firstAmounts.get("end").intValue()) {
					if (firstAmounts.get("verb") == null || firstAmounts.get("verb").equals(new Integer(0))) {
						if (secondAmounts.get("verb") != null) {
							firstAmounts.put("verb", secondAmounts.get("verb"));
						}
					}
					similarity = simpleMatchingCoefficient(matches, firstAmounts, weights);
				} else {
					if (secondAmounts.get("verb") == null || secondAmounts.get("verb").equals(new Integer(0))) {
						if (firstAmounts.get("verb") != null) {
							secondAmounts.put("verb", firstAmounts.get("verb"));
						}
					}
					similarity = simpleMatchingCoefficient(matches, secondAmounts, weights);
				}
				break;			
		}
				
		return similarity;
	}
	
	private List<Diff> changeComplements(List<Diff> differences) {
		List<Diff> changes = new Vector<Diff>();
		for (Diff d : differences) {			
			Diff complement = findComplement(d, changes);				
			if (complement != null) {
				AttributeChange attributeChange = CompareFactory.eINSTANCE.createAttributeChange();
				EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
				//System.out.println(((ReferenceChange) d).getReference().eClass());
				//attribute.setEType(((ReferenceChange) d).getReference().getEType());						
				attributeChange.setAttribute(attribute);							
				attributeChange.setKind(DifferenceKind.CHANGE);
				//changes.add(attributeChange);
			} else {
				changes.add(d);
			}			
		}
		return changes;
	}
	
	private List<Diff> filterDifferences(List<Diff> differences, double threshold) {
		List<Diff> changes = new Vector<Diff>(); 
		if (threshold < 0.0 || threshold > 1.0) {
			threshold = 1.0;
		}		
		for (Diff d : differences) {
			if (d instanceof ReferenceChange) {
				Diff complement = findComplement(d, changes);				
				if (complement != null) {					
					String value = valueOf(((ReferenceChange) d).getValue()).toString();
					String complementarValue = valueOf(((ReferenceChange) complement).getValue()).toString();
					double proximity = 1 - diceDistance(value, complementarValue);
					if (proximity < threshold) {
						complement.setKind(DifferenceKind.CHANGE);						
					} else if (endsMatching != null && ((ReferenceChange) d).getReference().getName().equals("end")) {
						endsMatching.add(new Double(proximity));
					}
					log.append("proximidade entre " + value + " e " + complementarValue + ": " + proximity + "\n");
				} else {
					changes.add(d);
				}			
			} else if (d instanceof AttributeChange) { 
				String leftValue = d.getMatch().getLeft().eGet(((AttributeChange) d).getAttribute()).toString();
				String rightValue = d.getMatch().getRight().eGet(((AttributeChange) d).getAttribute()).toString();
				double proximity = 1 - diceDistance(leftValue, rightValue);
				if (proximity < threshold) {
					changes.add(d);
				} else if (endsMatching != null && ((AttributeChange) d).getAttribute().getEContainingClass().getName().equals("end")) {
					endsMatching.add(new Double(proximity));
				}
				//log.append("proximidade entre " + leftValue + " e " + rightValue + ": " + proximity + "\n");
			}
		}
		
		return changes;
	}

	private double simpleMatchingCoefficient(Map<String,Double> matches, Map<String,Integer> elements, Map<String,Integer> weights) {
		double matchesWeighted = 0.0;
		double elementsWeighted = 0.0;
		
		if(elements == null) {
			elements = new HashMap<String,Integer>();
		}
		if (matches != null && weights != null) {			
			for (String key : weights.keySet()) {				
				if (elements.get(key) != null) {
					elementsWeighted = elementsWeighted + weights.get(key) * elements.get(key);
				} 
				if (matches.get(key) != null) {
					//System.out.println(key + ":" + matches.get(key));
					matchesWeighted = matchesWeighted + weights.get(key) * matches.get(key);
				}
			}			
		}
		
		if (elementsWeighted == 0.0 || matchesWeighted > elementsWeighted) {
			return 0.0;
		}
		
		
		return matchesWeighted / elementsWeighted;
	}
	
	private double diceCoefficient(Map<String,Double> matches, Map<String,Integer> firstElements, Map<String,Integer> secondElements, Map<String,Integer> weights) {
		double matchesWeighted = 0.0;
		double elementsWeighted = 0.0;
		
		if(firstElements == null) {
			secondElements = new HashMap<String,Integer>();
		}
		if(secondElements == null) {
			secondElements = new HashMap<String,Integer>();
		}
		if (matches != null && weights != null) {			
			for (String key : weights.keySet()) {				
				if (firstElements.get(key) != null) {
					elementsWeighted = elementsWeighted + weights.get(key) * firstElements.get(key);
				}
				if (secondElements.get(key) != null) {
					elementsWeighted = elementsWeighted + weights.get(key) * secondElements.get(key);
				}
				if (matches.get(key) != null) {					
					matchesWeighted = matchesWeighted + weights.get(key) * matches.get(key);
				}
			}			
		}
		
		if (elementsWeighted == 0.0 || 2 * matchesWeighted > elementsWeighted) {
			return 0.0;
		}
		
		
		return 2 * matchesWeighted / elementsWeighted;
	}
	
	private double diceDistance(String value1, String value2) {
		double distance = 1.0;
		Map<String, Integer> bigrams1 = new HashMap<String, Integer>();
		Map<String, Integer> bigrams2 = new HashMap<String, Integer>();
		Map<String, Integer> bigramWeights = new HashMap<String, Integer>();
		Map<String, Double> matchingBigrams = new HashMap<String, Double>();
		for (int i = 0; i <= value1.length() - 2; i = i + 1) {
			String bigram = value1.substring(i, i + 2);
			if (bigrams1.get(bigram) == null) {
				bigrams1.put(bigram, new Integer(1));
			} else {
				bigrams1.put(bigram, new Integer(bigrams1.get(bigram).intValue() + 1));
			}
			if (bigramWeights.get(bigram) == null) {
				bigramWeights.put(bigram, new Integer(1));
			}
		
		}
		for (int i = 0; i <= value2.length() - 2; i = i + 1) {
			String bigram = value2.substring(i, i + 2);
			if (bigrams2.get(bigram) == null) {
				bigrams2.put(bigram, new Integer(1));
			} else {
				bigrams2.put(bigram, new Integer(bigrams2.get(bigram).intValue() + 1));
			}
			if (bigramWeights.get(bigram) == null) {
				bigramWeights.put(bigram, new Integer(1));
			}
			if (bigrams1.get(bigram) != null) { //match
				if (matchingBigrams.get(bigram) == null) {
					matchingBigrams.put(bigram, new Double(1.0));
				} else {
					matchingBigrams.put(bigram, new Double(matchingBigrams.get(bigram).doubleValue() + 1.0));
				}
			}
		}
		distance = 1 - diceCoefficient(matchingBigrams, bigrams1, bigrams2, bigramWeights);
		return distance;
	}
	
	private double jaccardIndex(Map<String,Double> matches, Map<String,Integer> firstElements, Map<String,Integer> secondElements, Map<String,Integer> weights) {
		//double dice = diceCoefficient(matches, firstElements, secondElements, weights);
		double matchesWeighted = 0.0;
		double elementsWeighted = 0.0;
		
		if(firstElements == null) {
			if(secondElements == null) {
				return 1.0;
			}
			firstElements = new HashMap<String,Integer>();			
		}
		if(secondElements == null) {
			secondElements = new HashMap<String,Integer>();
		}
		if (matches != null && weights != null) {			
			for (String key : weights.keySet()) {
				if (firstElements.get(key) != null) {
					elementsWeighted = elementsWeighted + weights.get(key) * firstElements.get(key);
				} 
				if (secondElements.get(key) != null) {
					elementsWeighted = elementsWeighted + weights.get(key) * secondElements.get(key);
				} 
				if (matches.get(key) != null) {					
					matchesWeighted = matchesWeighted + weights.get(key) * matches.get(key);
				}
			}			
		}
		
		if (elementsWeighted == 0.0) {
			return 1.0;
		}
		
		if (matchesWeighted >= elementsWeighted) {
			return 0.0;
		}
		
		return matchesWeighted / (elementsWeighted - matchesWeighted);
		//return dice / (2 - dice);
	}
	
	private Map<String,Integer> verifyWeights(Map<String,Integer> weights) {
		if (weights == null) {
			weights = new HashMap<String, Integer>();
		}
		if (weights.get("role") == null){
			weights.put("role", new Integer(1));
		}
		if (weights.get("means") == null){
			weights.put("means", new Integer(1));
		}
		if (weights.get("end") == null){
			weights.put("end", new Integer(1));
		}
		if (weights.get("verb") == null){
			weights.put("verb", new Integer(1));
		}
		return weights;
	}
	
	private Vector<String> getValues(String adress, String name) {
		Vector<String> values = new Vector<String>();
		ResourceSet resourceSet = new ResourceSetImpl();		
		resourceSet.getResource(URI.createFileURI(adress), true);
		for (Resource r : resourceSet.getResources()) {
			for (EObject o : r.getContents()) {
				for (EObject c : o.eContents()) {
					if(c.eClass().getName().equals(name)) {						
						String value = valueOf(c).toString();
						if (value.contentEquals(c.toString())) {
							int start = value.indexOf("value: ") + 7;
							value = value.substring(start, value.length() - 1);
						}						
						values.add(value);
					} else if (c instanceof means && name.equals("verb")) {
						actionVerb verb = ((means) c).getVerb();
						if (verb != null) {
							values.add(verb.getValue());
						}
					}									
				}				
			}			
		}		
		return values;
	}
	
	private Object valueOf(EObject object) {
		String value = object.toString();
		
		if (object instanceof role) {
			value = ((role) object).getValue();
		}
		if (object instanceof means) {
			value = ((means) object).getValue();
		}
		if (object instanceof actionVerb) {
			value = ((actionVerb) object).getValue();
		}
		if (object instanceof end) {
			value = ((end) object).getValue();
		}
		
		return value;
	}
	
	private String getValue(String adress, String name) {
		String value = null;
		
		Vector<String> values = getValues(adress, name);
		if (values != null && !values.isEmpty()) {
			value = values.get(0);
		}
		
		return value;
	}
	
	private Diff findComplement(Diff diff, List<Diff> list) {
		Diff complement = null;
		
		if (diff instanceof ReferenceChange) {
			String name = ((ReferenceChange) diff).getReference().getName();
			String kind = diff.getKind().toString();
			for (Diff d : list) {
				if (d instanceof ReferenceChange) {
					if (((ReferenceChange) d).getReference().getName().equals(name)) {
						if ((kind.equals("ADD") && d.getKind().toString().equals("DELETE"))) {
							complement = d;						
						} else if (kind.equals("DELETE") && d.getKind().toString().equals("ADD")) {
							complement = d;
						}
					}
				}					
			}
		}
		
		return complement;
	}
	
	public boolean sameElement(String uri1, String uri2, String elementName) {
		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();
		resourceSet1.getResource(URI.createFileURI(uri1), true);		
		resourceSet2.getResource(URI.createFileURI(uri2), true);									
		IComparisonScope scope = new DefaultComparisonScope(resourceSet1, resourceSet2, null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);
		List<Diff> differences = comparison.getDifferences();		
		int endsChanged = 0;
		boolean equal = true;
					
		for (Diff diff : differences) {
			String name = null;
			if (diff instanceof ReferenceChange) {
				name = ((ReferenceChange) diff).getReference().getName();
			} else if (diff instanceof AttributeChange) {
				name = ((AttributeChange) diff).getAttribute().getEContainingClass().getName();
			}
			if (name.equals("actionVerb")) {
				name = "verb";
			}
		
			if (name.equals(elementName)) {
				if (name.equals("end") && !diff.getKind().equals("MOVE")) {
					endsChanged = endsChanged + 1;
				} else {
					equal = false;					
				}
			} 
		}
		
		if (elementName.equals("end")) {
			int higherAmountOfEnds  = getValues(uri1, "end").size();		
			int amountOfEnds = getValues(uri2, "end").size();		
			if (amountOfEnds > higherAmountOfEnds) {
				higherAmountOfEnds = amountOfEnds;
			}			
			if (higherAmountOfEnds <= endsChanged) {
				equal = false;
			}
		}
		
		return equal;
	}
	
	public static void generateUserStories() {
		File file = new File("userstories\\UserStories.txt");
		try {
			int i = 108;
            Scanner arq = new Scanner(file);
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter("userstories\\us"+i+".userstory"));
            while (arq.hasNextLine()) {
                String linha = arq.nextLine();
                buffWrite.append(linha);
                if (linha.equals("</userstory:spec>")) {
                	buffWrite.close();
                	i = i + 1;
                	buffWrite = new BufferedWriter(new FileWriter("userstories\\us"+i+".userstory"));
                }
            }
            buffWrite.close();
            arq.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
	}
	
	/*private static void printPairs(Vector<Par<String, Integer>> vetor) {
		if (vetor != null) {
			@SuppressWarnings("unchecked")
			Vector<Par<String, Integer>> pares = (Vector<Par<String, Integer>>) vetor.clone();
			while(pares.size() > 0) {
				int n = 1;
				int k = 1;
				Par<String, Integer> p = pares.get(0);
				System.out.print(p.getPrimeiro() + " : " + p.getSegundo());
				for(; k < pares.size(); k = k + 1) {
					if (Par.iguais(pares.get(k).getPrimeiro(),p.getPrimeiro())) {
						System.out.print(", " + pares.get(k).getSegundo());
						n = n + 1;
					}
				}
				for(k = pares.size() - 1; k > 0; k = k - 1) {
					if (Par.iguais(pares.get(k).getPrimeiro(),p.getPrimeiro())) {
						pares.remove(k);
					}
				}
				pares.remove(0);
				System.out.println(" Total: " + n);
			}
		}
	}*/	

}
