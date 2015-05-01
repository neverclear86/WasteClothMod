package modding.wasteclothmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

	/* CCタートルの色を落とすアイテムを追加（ボロ雑巾）*/



@Mod(modid = WasteClothModCore.MODID, version = WasteClothModCore.VERSION,
	dependencies = "after:ComputerCraft")

public class WasteClothModCore {
	public static final String MODID = "WasteClothMod";
	public static final String VERSION = "1.0";

	public static final CreativeTabs tabWasteCloth = new CreativeTabWasteCloth("WasteCloth");
		//クリエイティブタブを追加

	public static Item itemWasteCloth;
		//アイテムの変数宣言

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{

		itemWasteCloth = new ItemWasteCloth();
		GameRegistry.registerItem(itemWasteCloth, "itemWasteCloth");
			//アイテムを登録
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		WasteClothRecipeRegister.addItemRecipe();
			//レシピ登録メソッドの呼び出し
	}

}
