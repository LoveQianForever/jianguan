package com.ncs.gsyt.modules.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


public class RadrChart {

	private final float touka = 0.3f;

	private final int MARKSIZE = 12;

	private float kakudo;

	private final int length = 150;

	private final int WIDTH = 600;

	private final int HEIGHT = 400;

	private final Point CENTER = new Point((this.WIDTH / 2), (this.HEIGHT / 2));

	private String[] column;

	private float[] sindansya_data = {1,3.2f,2.5f,4.9f,1,3,2,4};

	private float[] hyokasya_data = {2,4,4.1f,3,2,4.2f,1,1.3f};

	private int[] hyokasya_data1 = {2,1,3,4,2,1,4,3};

	List dataList = null;
	List curList = null;
	List nameList = null;
	
	private final Color SINDANSYA_COLOR = Color.BLUE;

	private final Color HYOKASYA_COLOR = Color.RED;

	private final int MEMORI = 5;

	private String login_no;

	public RadrChart(final String login_no, final String[] column, List _dataList,List _curList,List _nameList) {
		this.login_no = login_no;
		this.column = column;
		this.kakudo = (float) 360 / (float) column.length;
		
		dataList = _dataList;
		curList = _curList;
		nameList = _nameList;
	}

	public void setSindansyaData(final float[] data) {
		this.sindansya_data = data;
	}
	
	public void setHyokasyaData(final float[] data) {
		this.hyokasya_data = data;
	}

	public BufferedImage makeRadarChart() throws Exception {
		try {
			final BufferedImage img = new BufferedImage(this.WIDTH, this.HEIGHT, BufferedImage.TYPE_INT_RGB);
			
			final Graphics2D g = img.createGraphics();
			final Composite Default_Com = g.getComposite();
			final AlphaComposite composite = AlphaComposite.getInstance(3, this.touka);
			
			g.setPaint(Color.white);
			g.fillRect(0, 0, this.WIDTH, this.HEIGHT);
			g.setPaint(Color.black);

			//生成雷达图外框
			for (int i = 0; i < this.MEMORI + 1; i+=5) {
				Point p0 = this.getPoint(0, ((i * this.length) / this.MEMORI));
				for (int j = 1; j < this.column.length + 1; j++) {
					final Point p1 = this.getPoint(j * this.kakudo, ((i * this.length) / this.MEMORI));
					g.drawLine(p0.x, p0.y, p1.x, p1.y);
					p0 = p1;
				}
			}
			
			//生成雷达图轴线
			for (int i = 0; i < this.column.length; i++) {
				final Point p0 = this.getPoint((i * this.kakudo), this.length);
				g.drawLine(p0.x, p0.y, this.CENTER.x, this.CENTER.y);
			}
			
			g.setColor(Color.black);
			//生成雷达图标尺
			for (int i = 0; i < this.MEMORI + 1; i++) {
				final Point p0 = this.getPoint(0, ((i * this.length) / this.MEMORI));
				g.drawString(String.valueOf(i), p0.x + 5, p0.y);
			}
			//生成雷达图各维度名称
			for (int i = 0; i < this.column.length; i++) {
				final Point p_margin = new Point(15, 0);
				final int line = g.getFontMetrics().stringWidth(this.column[i]);
				final Point p = this.getPoint(i * this.kakudo, this.length);
				
				if (i == 0) {
					p_margin.y = p_margin.x * (-1);
				     p_margin.x = 0;
				} else if (i - 1 == this.column.length / 2 - 1) {
					 p_margin.y = p_margin.x;
				     p_margin.x = 0;
				} else if (i > this.column.length / 2) {
					p_margin.x = (line + p_margin.x) * (-1);
				}
				
				g.drawString(this.column[i], (p.x + p_margin.x), (p.y + p_margin.y));
				g.drawLine((p.x + p_margin.x), (p.y + p_margin.y), (p.x + p_margin.x + line), (p.y + p_margin.y));
			}
			
			int num = curList.size();
			//生成雷达图各维度曲线
			for (int i = 0; i < num; i++) {
				float[] value;
				g.setColor((Color)curList.get(i));
			    value = (float[])dataList.get(i);
			    
			    Point p0 = this.getPoint(0, ((this.length * value[0]) / this.MEMORI));
			    final int[] fill_x = new int[this.column.length];
			    final int[] fill_y = new int[this.column.length];
			    for (int j = 0; j < this.column.length; j++) {
			    	Point p1 = this.getPoint(j * this.kakudo, ((this.length * value[j]) / this.MEMORI));
			    	g.drawLine(p0.x, p0.y, p1.x, p1.y);
			    	
			    	p0 = p1;
			        fill_x[j] = p1.x;
			        fill_y[j] = p1.y;
			        if (j == (this.column.length - 1)) {
			        	p1 = this.getPoint(0, ((this.length * value[0]) / this.MEMORI));
			        	g.drawLine(p0.x, p0.y, p1.x, p1.y);
			        }
			    }
			}
			
			//输出雷达图例
			this.drawLineInfo(g, 10, 10);
			return img;
		} catch (final Exception e) {
			throw e;
		}
	}
	
	private Point getPoint(final float kaku, final float length) {
		final double radian = (Math.PI / 180.0 * kaku);

		final int x = (int) (this.CENTER.x + Math.sin(radian) * length);
		final int y = (int) (this.CENTER.y - Math.cos(radian) * length);
		return new Point(x, y);
	}
	
	private void drawLineInfo(final Graphics2D g, int x, int y) {
		final int x0 = x;

		final int y0 = y;

		final int FONT_SIZE = g.getFont().getSize();
		final int MARGIN = 15;
		final int LINE_WIDTH = 30;
		final int LINE_HEIGHT = 2;

		int maxLength = 0;
		x = x + MARGIN;
		y = y + MARGIN;

		int num = this.curList.size();

		for (int i = 0; i < num; i++) {
			String name;
			g.setColor((Color) curList.get(i));
			name = (String) nameList.get(i);

			g.fillRect(x, y, LINE_WIDTH, LINE_HEIGHT);
			g.drawString(name, (x + LINE_WIDTH + 5), (y + FONT_SIZE / 2));

			if (maxLength < (LINE_WIDTH + 5 + g.getFontMetrics().stringWidth(
					name))) {
				maxLength = LINE_WIDTH + 5
						+ g.getFontMetrics().stringWidth(name);
			}

			y = y + MARGIN;
		}

		g.setColor(Color.black);
		g.drawRect(x0, y0, MARGIN * 2 + maxLength, y - y0 + LINE_HEIGHT);
	}
	
	public static void main(String[] args) {
		String[] colums = new String[]{"现实型","研究型","艺术型","社会型","企业型","常规型",};
		List<Color> _curList = new ArrayList<Color>();
		_curList.add(Color.RED);
		List<float[]> _dataList = new ArrayList<float[]>();
		_dataList.add(new float[]{1,3.2f,2.5f,4.9f,1,3});
		List<String> _nameList = new ArrayList<String>();
		_nameList.add("职业兴趣");
		
		RadrChart chart = new RadrChart("111", colums, _dataList, _curList, _nameList);
		try {
			BufferedImage img = chart.makeRadarChart();
			ImageIO.write(img, "JPG", new File("e:/test.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
