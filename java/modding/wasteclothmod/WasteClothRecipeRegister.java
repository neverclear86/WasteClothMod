package modding.wasteclothmod;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class WasteClothRecipeRegister
{

	//アイテムレシピ追加

	static void addItemRecipe(){

		GameRegistry.addShapelessRecipe(                                            //型なしレシピの追加
				new ItemStack(WasteClothModCore.itemWasteCloth),                    //出来るアイテム
				new ItemStack(Blocks.carpet, 1, OreDictionary.WILDCARD_VALUE),      //カーペット1つ　メタデータは問わない
				Items.water_bucket                                                  //水バケツ1つ
		);
	}
}
