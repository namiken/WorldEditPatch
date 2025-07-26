package com.sk89q.worldedit_custom.bukkit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

public class CustomWorldEditPlugin extends WorldEditPlugin {

  @Override
  public List<String> onTabComplete(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    //World EditのTabCompleteで鯖落ちすることがあるので無効化する
    System.out
        .println("WorldEdit Tag Canceled!!: sender:" + sender.getName() + ", cmd:" + cmd.getName() + ", commandLabel" +
            commandLabel + ", args:" + Arrays.toString(args));
    return new ArrayList<String>();
  }
}
