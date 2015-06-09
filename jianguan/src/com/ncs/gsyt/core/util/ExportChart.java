package com.ncs.gsyt.core.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.io.FileOutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;



public class ExportChart {

	public static void export(String pathFile, double[] date) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.addValue(date[0], "职业技能倾向", "VATC-1");
		dataset.addValue(date[1], "职业技能倾向", "VATC-2");
		dataset.addValue(date[2], "职业技能倾向", "VATC-3");
		dataset.addValue(date[3], "职业技能倾向", "VATC-4");
		dataset.addValue(date[4], "职业技能倾向", "VATC-5");
		dataset.addValue(date[5], "职业技能倾向", "VATC-6");
		dataset.addValue(date[6], "职业技能倾向", "VATC-7");
		
		JFreeChart chart = ChartFactory.createBarChart3D("",//图表标题
				"", // 目录轴的显示标签
				"", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				false, // 是否显示图例(对于简单的柱状图必须是 false
				false, // 是否生成工具
				false // 是否生成URL链接
		);
		//chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, 
		//		RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		CategoryPlot p = chart.getCategoryPlot();
		//x轴操作
		CategoryAxis domainAxis = p.getDomainAxis(); 
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);//斜向显示
		ValueAxis rAxis = p.getRangeAxis();//对Y轴做操作
		rAxis.setRange(0, 2);
		rAxis.setUpperMargin(0.15);//最高的柱与框架的距离
		rAxis.setLowerMargin(0.15);//最低的柱与框架的距离
		
		CustomBarRenderer renderer = new CustomBarRenderer(new Paint[] {Color.RED, Color.YELLOW, new Color(128,64,0), Color.ORANGE, 
				Color.BLUE, Color.GREEN, new Color(255,0,255)});//继承基本BarRenderer3D类重写getItemPaint方法生成同一组柱子不同颜色
		renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());//显示每个柱的数值 
		renderer.setItemLabelsVisible(true);//必须有此方法柱图上数字才能显示
		renderer.setItemLabelAnchorOffset(10D);//数字与柱图的距离位置
		renderer.setPositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,TextAnchor.BASELINE_CENTER));
		renderer.setItemLabelFont(new Font("黑体",Font.PLAIN,15));
		p.setForegroundAlpha(1.0f);//设置柱的透明度
		
		p.setRenderer(renderer);//将修改后的属性值保存到图中
		
		FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream(pathFile);
			ChartUtilities.writeChartAsJPEG(fos_jpg,chart,400,250,null);
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
		//ExportChart.export();
	}
}
