package com.ncs.gsyt.core.util;

import java.awt.Paint;

import org.jfree.chart.renderer.category.BarRenderer3D;

public class CustomBarRenderer extends BarRenderer3D {

	private Paint colors[];

	public Paint getItemPaint(int i, int j) {
		return colors[j % colors.length];
	}

	public CustomBarRenderer(Paint apaint[]) {
		colors = apaint;
	}
}
