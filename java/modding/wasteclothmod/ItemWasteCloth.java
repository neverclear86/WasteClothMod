package modding.wasteclothmod;

import java.lang.reflect.Method;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import dan200.computercraft.api.turtle.ITurtleAccess;



public class ItemWasteCloth extends Item
{

	public ItemWasteCloth()
	{
		super();
		this.setCreativeTab(WasteClothModCore.tabWasteCloth)		//クリエタブに追加
			.setUnlocalizedName("WasteCloth")		//システム名登録
			.setTextureName("WasteClothMod:waste_cloth")		//テクスチャ登録
			.setHasSubtypes(true)		//ダメージ値を使う
			.setMaxDamage(15)		//耐久値設定
			.setContainerItem(Items.bucket)		//作成時返却アイテム指定
			.setNoRepair()		//金床使えないよ
			.setMaxStackSize(1);		//スタックできる数


	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		/*onItemUseFirstは右クリック時にブロック側の処理より先に処理される
		  onItemUseだとブロックの後で処理される	（タートルだとGUIが開く）*/

		TileEntity tile = world.getTileEntity(x, y, z);											/*リフレクション*/
																								/*無理やりメソッドを呼び出すっぽい*/
		if (tile != null) {
		    try {
		        Method methodGetAccess = tile.getClass().getMethod("getAccess");
		        ITurtleAccess turtleAccess = (ITurtleAccess)methodGetAccess.invoke(tile);

		        if (!world.isRemote && turtleAccess.getDyeColour() != -1){			//鯖側の処理で、タートルが初期色じゃないとき

			        turtleAccess.setDyeColour(-1);									//タートルの色を初期に戻す

			        stack.damageItem(1, player);									//アイテムの耐久値を減らす

			        return true;													//trueにするとGUIを開かない
		        }

		    } catch (Exception e) {

		    }
		}

		return false;

	}


}
