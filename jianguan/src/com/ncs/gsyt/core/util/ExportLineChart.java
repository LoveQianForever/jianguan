package com.ncs.gsyt.core.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.FileOutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

public class ExportLineChart {

	public static void export(String pathFile, double[] date) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		

		dataset.addValue(date[0], "职业技能倾向", "第一类");
		dataset.addValue(date[1], "职业技能倾向", "第二类");
		dataset.addValue(date[2], "职业技能倾向", "第三类");
		dataset.addValue(date[3], "职业技能倾向", "第四类");
		dataset.addValue(date[4], "职业技能倾向", "第五类");
		dataset.addValue(date[5], "职业技能倾向", "第六类");
		dataset.addValue(date[6], "职业技能倾向", "第七类");

		JFreeChart chart = ChartFactory.createLineChart("",// 图表标题
				"", // 目录轴的显示标签
				"", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				false, // 是否显示图例(对于简单的柱状图必须是 false
				false, // 是否生成工具
				false // 是否生成URL链接
				);

		CategoryPlot plot = chart.getCategoryPlot();
		plot.setRangeGridlinePaint(Color.LIGHT_GRAY); 
		plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
		plot.setBackgroundPaint(Color.WHITE);
		plot.setAxisOffset(new RectangleInsets(0d, 0d, 0d, 5d));
		plot.getDomainAxis().setTickLabelFont(new Font("宋体",Font.ITALIC,12));//横坐标字体
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		
		ValueMarker marker = new ValueMarker(1.2);
		marker.setPaint(Color.red);
		marker.setAlpha(0.8f);
		marker.setLabel("采样点");
		plot.addRangeMarker(marker);
		
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRange(true);
		rangeAxis.setLowerBound(0.0);
		rangeAxis.setUpperBound(2.0);
		rangeAxis.setUpperMargin(0.10);
		rangeAxis.setLabelAngle(Math.PI / 2.0);
		
		LineAndShapeRenderer ren = (LineAndShapeRenderer) plot.getRenderer();
		ren.setShapesVisible(true);
		ren.setBaseLinesVisible(true);
		ren.setSeriesPaint(0, Color.BLACK);// 设置线条的颜色
		ren.setBaseItemLabelsVisible(true);
		ren.setStroke(new BasicStroke(2.0f),false);
		ren.setBaseItemLabelsVisible(true);//显示点值
		ren.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
		ren.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		ren.setBaseItemLabelPaint(Color.RED);

		FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream(pathFile);
			ChartUtilities.writeChartAsJPEG(fos_jpg, chart, 400, 250, null);
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				fos_jpg.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		//ExportLineChart.export("d:\\steelLine.jpg");
	}
}
