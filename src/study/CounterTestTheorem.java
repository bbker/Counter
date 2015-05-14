package study;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.fest.swing.fixture.FrameFixture;

public class CounterTestTheorem {
	private FrameFixture frame;//定义FrameFixture变量（在fest-swing。jar中）
	

	@Before
	public void setUp() throws Exception {
		frame=new FrameFixture(new Theorem());//对Theorem（勾股定理）实例化给frame
		frame.show();//显示Theorem窗体		
	}

	@After
	public void tearDown() throws Exception {
		frame.cleanUp();//清理Theorem窗口		
	}

	@Test	
	public void testTheorem(){//对Theorem进行测试
		frame.textBox("aa").enterText("3");//在aa文本框中输入3
		frame.textBox("bb").enterText("4");//在bb文本框中输入4
		frame.button("c").click();//单击按钮C
		frame.textBox("cc").requireText("5");//结果为5正确，否则出错
		clear();
		frame.textBox("aa").enterText("6");//
		frame.textBox("cc").enterText("10");//同上
		frame.button("b").click();//
		frame.textBox("bb").requireText("8");//	
		clear();
	}
	public void clear(){//将文本框的内容清空
		frame.textBox("aa").deleteText();
		frame.textBox("bb").deleteText();
		frame.textBox("cc").deleteText();
	}

}
