package br.com.inmetrics.teo.core.screenshot;

public class SimpleScreenshotConfiguration implements IScreenshotConfiguration {

	@Override
	public Integer getZoomIn() {
		return DEFAULT_SIZE_ZOOM_IN;
	}

	@Override
	public Integer getZoomOut() {
		return DEFAULT_SIZE_ZOOM_OUT;
	}
	
	@Override
	public void setZoomIn(Integer zoomIn) {
	}
	
	@Override
	public void setZoomOut(Integer zoomOut) {
	}
	
}
