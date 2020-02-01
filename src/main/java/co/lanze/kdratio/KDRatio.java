package co.lanze.kdratio;

import co.lanze.kdratio.utils.ColorTranslate;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class KDRatio extends PlaceholderExpansion {

  @Override
  public String getIdentifier() {
    return "kdratio";
  }

  @Override
  public String getAuthor() {
    return "leadz91";
  }

  @Override
  public String getVersion() {
    return "1.1.0";
  }

  @Override
  public boolean canRegister() {
    return true;
  }

  @Override
  public String onPlaceholderRequest(Player player, String identifier) {

    int playerKills = player.getStatistic(Statistic.PLAYER_KILLS);
    int playerDeaths = player.getStatistic(Statistic.DEATHS);
    double kdRatio = (double)playerKills / (double)playerDeaths;

    if (identifier.equals("kills")) {
      return Integer.toString(playerKills);
    }

    if (identifier.equals("deaths")) {
      return Integer.toString(playerDeaths);
    }

    if (identifier.equals("ratio")) {
      return String.format("%.2f", kdRatio);
    }

    if (identifier.equals("ratio_color")) {
      if (kdRatio >= 0) {
        return ColorTranslate.translate("&a" + String.format("%.2f", kdRatio));
      }

      return ColorTranslate.translate("&c" + String.format("%.2f", kdRatio));
    }

    return null;
  }
}
