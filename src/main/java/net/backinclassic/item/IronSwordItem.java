
package net.backinclassic.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.backinclassic.BackInClassicModElements;

@BackInClassicModElements.ModElement.Tag
public class IronSwordItem extends BackInClassicModElements.ModElement {
	@ObjectHolder("back_in_classic:extreme_iron_sword")
	public static final Item block = null;
	public IronSwordItem(BackInClassicModElements instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 256;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT));
			}
		}, 3, 16f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("extreme_iron_sword"));
	}
}
