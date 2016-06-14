import org.junit.Test;

import cn.cnic.algorithm.tree.bplustree.BPlusTree;
import cn.cnic.algorithm.tree.bplustree.InnerNode;
import cn.cnic.algorithm.tree.bplustree.Node;
import cn.cnic.algorithm.tree.bplustree.Value;


public class TestTree {
  
	public void testAddTree()
	{
		BPlusTree<Integer> bpt = new BPlusTree<Integer>();
		
		long start = System.currentTimeMillis();
		for(int i=0;i<100;i++)
		{
			bpt.addNode(i,null);
		}
		bpt.addNode(3,null);
		System.out.println("耗时："+(System.currentTimeMillis()-start));
		bpt.visitAll();
		
		System.out.println("*********split line**********");
		InnerNode<Integer> in = (InnerNode<Integer>)(bpt.getRoot());
		for(Integer i: in.getKeyList())
		{
			System.err.print(i+"\t");
		}
		System.err.println();
		System.err.println(in.findNode(35));
		System.err.println(in.findNode(37));
		System.out.println("*********split line**********");
		Node<Integer> node  = ((InnerNode<Integer>)(bpt.getRoot())).getIndexList().get(0);
		for(Integer i: node.getKeyList())
		{
			System.err.print(i+"\t");
		}
		System.out.println();
		node  = ((InnerNode<Integer>)(bpt.getRoot())).getIndexList().get(1);
		for(Integer i: node.getKeyList())
		{
			System.err.print(i+"\t");
		}
		((InnerNode<Integer>)(bpt.getRoot())).getIndexList().get(1);
	}
	
	public void testAddTreeWithValue()
	{
		BPlusTree<Integer> bpt = new BPlusTree<Integer>();
		
		long start = System.currentTimeMillis();
		for(int i=0;i<100;i++)
		{
			Value v = new Value(i+"");
			System.err.println(v.getText());
			bpt.addNode(i,v);
		}
		bpt.addNode(3,new Value("30"));
		bpt.addNode(3,new Value("31"));
		bpt.addNode(3,new Value("32"));
		bpt.addNode(3,new Value("33"));
		bpt.addNode(3,new Value("34"));
		bpt.addNode(3,new Value("35"));
		System.out.println("耗时："+(System.currentTimeMillis()-start));
		bpt.visitAllWithValue();
	}
	
	public void testAddSplit()
	{
		BPlusTree<Integer> bpt = new BPlusTree<Integer>();
		
		long start = System.currentTimeMillis();
		for(int i=0;i<10000;i++)
		{
			bpt.addNode(i,null);
		}
		bpt.addNode(3,null);
		System.out.println("耗时："+(System.currentTimeMillis()-start));
		bpt.visitAll();
	}
	
	@Test
	public void testDelete()
	{
		BPlusTree<Integer> bpt = new BPlusTree<Integer>();
		
		long start = System.currentTimeMillis();
		for(int i=0;i<100;i++)
		{
			bpt.addNode(i,null);
		}
		/*bpt.removeNode(3);
		bpt.visitAll();*/
		/*System.out.println("******************************");
		bpt.removeNode(4);
		bpt.visitAll();
		System.out.println("******************************");
		bpt.removeNode(41);
		bpt.visitAll();*/
		System.out.println("耗时："+(System.currentTimeMillis()-start));
		System.err.println("*********split line**********");
		InnerNode<Integer> in = (InnerNode<Integer>)(bpt.getRoot());
		for(Integer i: in.getKeyList())
		{
			System.err.print(i+"\t");
		}
		System.err.println();
		System.err.println("*********split line**********");
		Node<Integer> node  = ((InnerNode<Integer>)(bpt.getRoot())).getIndexList().get(0);
		for(Integer i: node.getKeyList())
		{
			System.err.print(i+"\t");
		}
		System.err.println();
		node  = ((InnerNode<Integer>)(bpt.getRoot())).getIndexList().get(1);
		for(Integer i: node.getKeyList())
		{
			System.err.print(i+"\t");
		}
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bpt.removeNode(3);
		bpt.visitAll();
		((InnerNode<Integer>)(bpt.getRoot())).getIndexList().get(1);
		
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("******************************");
		bpt.removeNode(17);
		bpt.visitAll();
		((InnerNode<Integer>)(bpt.getRoot())).getIndexList().get(1);
	}
	
	public void testDeleteWithValue()
	{
		BPlusTree<Integer> bpt = new BPlusTree<Integer>();
		
		long start = System.currentTimeMillis();
		for(int i=0;i<100;i++)
		{
			bpt.addNode(i,new Value(i+""));
		}
		bpt.removeNode(3);
		bpt.visitAllWithValue();
		System.out.println("******************************");
		bpt.removeNode(41);
		bpt.visitAllWithValue();
		System.out.println("******************************");
		bpt.removeNode(99);
		bpt.visitAllWithValue();
		System.out.println("耗时："+(System.currentTimeMillis()-start));
		
		InnerNode<Integer> in = (InnerNode<Integer>)(bpt.getRoot());
		for(Integer i: in.getKeyList())
		{
			System.err.print(i+"\t");
		}
		System.err.println();
		System.err.println(in.findNode(99));
		
		
	}
	
	public void testDeleteWithValueWithRoot()
	{
		BPlusTree<Integer> bpt = new BPlusTree<Integer>();
		
		long start = System.currentTimeMillis();
		for(int i=0;i<11;i++)
		{
			bpt.addNode(i,new Value(i+""));
		}
		bpt.visitAllWithValue();
		bpt.removeNode(10);
		bpt.visitAllWithValue();
		System.out.println("耗时："+(System.currentTimeMillis()-start));
	}
	
	
	public void testFindTree()
	{
		BPlusTree<Integer> bpt = new BPlusTree<Integer>();
		long start = System.currentTimeMillis();
		for(int i=0;i<100;i++)
		{
			bpt.addNode(i,new Value(i+1));
		}	
		System.err.println(bpt.find(99).getText());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
