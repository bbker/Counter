package study;

import static org.junit.Assert.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CounterTestEquation {

private FrameFixture frame;//定义FrameFixture变量（在fest-swing。jar中）
	@Before
	public void setUp() throws Exception {
		frame=new FrameFixture(new Equation());//对Theorem（勾股定理）实例化给frame
		frame.show();//显示Theorem窗体		
	}

	@After
	public void tearDown() throws Exception {
		frame.cleanUp();//清理Theorem窗口		
	}

	@Test	
	public void testEquation(){//对Theorem进行测试
	        //测试d〈0无解情况
		frame.textBox("a=").enterText("1");//模拟键盘在文本框中输入1
		frame.textBox("b=").enterText("2");//模拟键盘在文本框中输入2
		frame.textBox("c=").enterText("2");//模拟键盘在文本框中输入2
		frame.button("x1").click();//模拟鼠标点击x1按钮
		frame.textBox("output").requireText("d小于0无解");//检查输出的结果是否是d小于0无解，是通过，否出错
		clear();
		//测试d=0，有2个相同解情况
		frame.textBox("a=").enterText("4");//模拟键盘在文本框中输入4
		frame.textBox("b=").enterText("4");//模拟键盘在文本框中输入4
		frame.textBox("c=").enterText("1");//模拟键盘在文本框中输入1
		frame.button("x1").click();//模拟鼠标点击x1按钮
		frame.textBox("output").requireText("-0.5");
		frame.textBox("output1").requireText("-0.5");//检查输出的结果是否是-0.5，是通过，否出错
		clear();
		//测试d>0，有2个解情况
		frame.textBox("a=").enterText("1");//模拟键盘在文本框中输入1
		frame.textBox("b=").enterText("3");//模拟键盘在文本框中输入3
		frame.textBox("c=").enterText("2");//模拟键盘在文本框中输入2
		frame.button("x1").click();//模拟鼠标点击x1按钮
		frame.textBox("output").requireText("-1.0");//检查输出的结果是否是-1.0，是通过，否出错
		frame.textBox("output1").requireText("-2.0");//检查输出的结果是否是-2.0，是通过，否出错
		clear();
	}
	public void clear(){//将文本框的内容清空
		frame.textBox("a=").deleteText();
		frame.textBox("b=").deleteText();
		frame.textBox("c=").deleteText();
	}


}
