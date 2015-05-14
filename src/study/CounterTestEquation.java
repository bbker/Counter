package study;

import static org.junit.Assert.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CounterTestEquation {

private FrameFixture frame;//����FrameFixture��������fest-swing��jar�У�
	@Before
	public void setUp() throws Exception {
		frame=new FrameFixture(new Equation());//��Theorem�����ɶ���ʵ������frame
		frame.show();//��ʾTheorem����		
	}

	@After
	public void tearDown() throws Exception {
		frame.cleanUp();//����Theorem����		
	}

	@Test	
	public void testEquation(){//��Theorem���в���
		frame.textBox("a=").enterText("1");//ģ��������ı���������1
		frame.textBox("b=").enterText("2");//ģ��������ı���������2
		frame.textBox("c=").enterText("2");//ģ��������ı���������2
		frame.button("x1").click();//ģ�������x1��ť
		frame.textBox("output").requireText("dС��0�޽�");//�������Ľ���Ƿ���dС��0�޽⣬��ͨ���������
		clear();
		frame.textBox("a=").enterText("4");//ģ��������ı���������4
		frame.textBox("b=").enterText("4");//ģ��������ı���������4
		frame.textBox("c=").enterText("1");//ģ��������ı���������1
		frame.button("x1").click();//ģ�������x1��ť
		frame.textBox("output").requireText("-0.5");//�������Ľ���Ƿ���-0.5����ͨ���������
		clear();
		frame.textBox("a=").enterText("1");//ģ��������ı���������1
		frame.textBox("b=").enterText("3");//ģ��������ı���������3
		frame.textBox("c=").enterText("2");//ģ��������ı���������2
		frame.button("x1").click();//ģ�������x1��ť
		frame.textBox("output").requireText("-1.0");//�������Ľ���Ƿ���-1.0����ͨ���������
		frame.textBox("output1").requireText("-2.0");//�������Ľ���Ƿ���-2.0����ͨ���������
		clear();
	}
	public void clear(){//���ı�����������
		frame.textBox("a=").deleteText();
		frame.textBox("b=").deleteText();
		frame.textBox("c=").deleteText();
	}


}
