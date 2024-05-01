package app.revanced.patches.music.general.carouselshelf

import app.revanced.patcher.data.ResourceContext
import app.revanced.patches.music.utils.compatibility.Constants.COMPATIBLE_PACKAGE
import app.revanced.patches.music.utils.integrations.Constants.COMPONENTS_PATH
import app.revanced.patches.music.utils.settings.CategoryType
import app.revanced.patches.music.utils.settings.SettingsPatch
import app.revanced.patches.shared.litho.LithoFilterPatch
import app.revanced.util.patch.BaseResourcePatch

@Suppress("unused")
object CarouselShelfPatch : BaseResourcePatch(
    name = "Hide carousel shelf",
    description = "Adds an option to hide the carousel shelf from the homepage and explore tab.",
    dependencies = setOf(
        LithoFilterPatch::class,
        SettingsPatch::class
    ),
    compatiblePackages = COMPATIBLE_PACKAGE
) {
    private const val FILTER_CLASS_DESCRIPTOR =
        "$COMPONENTS_PATH/CarouselShelfFilter;"

    override fun execute(context: ResourceContext) {
        LithoFilterPatch.addFilter(FILTER_CLASS_DESCRIPTOR)

        SettingsPatch.addSwitchPreference(
            CategoryType.GENERAL,
            "revanced_hide_carousel_shelf",
            "false"
        )

    }
}