//package breakout;
//
//import javafx.scene.Group;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.Paint;
//import javafx.scene.shape.Rectangle;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class ExplodingBlock extends Block{
//    private int numberOfHitsLeft;
//    private int centerX;
//    private int centerY;
//    private Rectangle thisBlock;
//    private static final String BLOCK_ID = "exploding_block";
//
//    public ExplodingBlock(int x, int y, Group root, List<Block> blockList){
//        numberOfHitsLeft = 10;
//        Paint BLOCK_COLOR = Color.BLACK;
//        centerX = x + BlockMaker.BLOCK_WIDTH / 2;
//        centerY = y + BlockMaker.BLOCK_HEIGHT / 2;
//
//        thisBlock = new Rectangle(x, y, BlockMaker.BLOCK_WIDTH, BlockMaker.BLOCK_HEIGHT);
//        thisBlock.setFill(BLOCK_COLOR);
//        thisBlock.setId(BLOCK_ID);
//
//    }
//
//    public void explode(List<Block> blockList){
//
//        for(Block block : blockList){
//            if(this.isTouching(block)){
//                block.updateBlocks();
//            }
//        }
//        blockList.remove(this.getThisBlock());
//    }
//
//    public static void addExplodingBlockToRootAndList(int x, int y, Group root, List<Block> blockList, ExplodingBlock myEB) {
//        blockList.add(myEB);
//        if(myEB.getThisBlock() != null){
//            root.getChildren().add(myEB.getThisBlock());
//        }
//    }
//}
