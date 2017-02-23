package br.com.inmetrics.teo.core.screenshot;

public interface IScreenshotConfiguration {
	public static final int DEFAULT_SIZE_ZOOM_IN = 100;
	public static final int DEFAULT_SIZE_ZOOM_OUT = 100;
	int getZoomIn();
	int getZoomOut();
}
