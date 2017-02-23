package br.com.inmetrics.teo.core.screenshot;

public interface IScreenshotConfiguration {
	public int DEFAULT_SIZE_ZOOM_IN = 100;
	public int DEFAULT_SIZE_ZOOM_OUT = 100;
	void setZoomIn(Integer zoomIn);
	void setZoomOut(Integer zoomOut);
	Integer getZoomIn();
	Integer getZoomOut();
}
