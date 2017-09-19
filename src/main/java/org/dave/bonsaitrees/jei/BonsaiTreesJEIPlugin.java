package org.dave.bonsaitrees.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.ItemStack;
import org.dave.bonsaitrees.init.Blockss;
import org.dave.bonsaitrees.trees.TreeType;
import org.dave.bonsaitrees.trees.TreeTypeRegistry;

@JEIPlugin
public class BonsaiTreesJEIPlugin implements IModPlugin {
    @Override
    public void register(IModRegistry registry) {
        registry.addRecipeCatalyst(new ItemStack(Blockss.bonsaiPot), BonsaiTreeRecipeCategory.UID);
        registry.handleRecipes(TreeType.class, new BonsaiTreeRecipeWrapperFactory(), BonsaiTreeRecipeCategory.UID);
        registry.addRecipes(TreeTypeRegistry.treeTypes.values(), BonsaiTreeRecipeCategory.UID);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new BonsaiTreeRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
    }
}
