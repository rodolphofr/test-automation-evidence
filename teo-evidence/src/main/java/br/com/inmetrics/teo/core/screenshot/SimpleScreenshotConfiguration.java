package br.com.inmetrics.teo.core.screenshot;

public class SimpleScreenshotConfiguration implements IScreenshotConfiguration {

	@Override
	public int getZoomIn() {
		return DEFAULT_SIZE_ZOOM_IN;
	}

	@Override
	public int getZoomOut() {
		return DEFAULT_SIZE_ZOOM_OUT;
	}
	
}
