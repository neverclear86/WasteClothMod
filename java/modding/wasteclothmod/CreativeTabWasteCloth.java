package modding.wasteclothmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabWasteCloth extends CreativeTabs
{
	public CreativeTabWasteCloth(String type)				//クリエイティブタブの追加
	{
		super(type);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()							//クリエイティブタブのアイコン
	{
		return WasteClothModCore.itemWasteCloth;

	}
}
