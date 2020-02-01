package co.lanze.kdratio.utils;

import org.bukkit.ChatColor;

public class ColorTranslate {

  public static String translate(String text) {
    return ChatColor.translateAlternateColorCodes('&', text);
  }
}
