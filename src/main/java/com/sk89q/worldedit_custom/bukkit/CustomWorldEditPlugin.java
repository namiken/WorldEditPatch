package com.sk89q.worldedit_custom.bukkit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

public class CustomWorldEditPlugin extends WorldEditPlugin {

  @Override
  public List<String> onTabComplete(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    //World EditのTabCompleteで鯖落ちすることがあるので無効化する
    System.out
        .println("[warn]WorldEdit Tag Canceled!!: sender:" + sender.getName() + ", cmd:" + cmd.getName()
            + ", commandLabel:" +
            commandLabel + ", args:" + Arrays.toString(args));
    return new ArrayList<String>();
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if (!(sender instanceof Player)) { return super.onCommand(sender, cmd, commandLabel, args); }

    boolean op = sender.isOp();
    if (op) { return super.onCommand(sender, cmd, commandLabel, args); }

    // OP持っていない場合はコマンドを実行しない
    System.out
        .println(
            "[warn]WorldEdit Command Canceled!!: sender:" + sender.getName() + ", cmd:" + cmd.getName()
                + ", commandLabel:" +
                commandLabel + ", args:" + Arrays.toString(args));
    return false;
  }
}
