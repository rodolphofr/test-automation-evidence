package br.com.inmetrics.teo.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.inmetrics.teo.core.Evidence;
import br.com.inmetrics.teo.core.EvidenceView;

/**
 * 
 * @author Rodolpho F. Rodrigues (@Rod)
 *
 */
public class EvidenceViewUtils {

	public static EvidenceView convertToEvidenceView(Evidence evidence) {
		return new EvidenceView(evidence);
	}
	
	public static List<EvidenceView> convertToList(List<Evidence> evidences) {
		List<EvidenceView> views = new ArrayList<EvidenceView>();
		evidences.forEach((e) -> views.add(convertToEvidenceView(e)));
		return views;
	}
	
}
