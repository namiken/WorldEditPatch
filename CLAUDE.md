# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a WorldEdit patch project that creates a custom Minecraft Bukkit plugin to fix a server crash issue. The project extends the original WorldEdit plugin by overriding the tab completion functionality to prevent server crashes.

## Architecture

- **Base Plugin**: Extends `com.sk89q.worldedit.bukkit.WorldEditPlugin`
- **Main Class**: `com/sk89q/worldedit_custom/bukkit/CustomWorldEditPlugin.java`
- **Build Process**: Uses Maven with Ant integration to unpack the original WorldEdit JAR and repackage it with custom modifications
- **Dependencies**: Spigot 1.8.8 and WorldEdit-Bukkit 6.1.5 (both as system dependencies in `/lib/`)

## Development Commands

### Build
```bash
mvn clean compile
mvn package
```

The build process:
1. Unpacks `lib/worldedit-bukkit-6.1.5.jar` into the output directory (excluding plugin.yml files)
2. Compiles the custom Java code
3. Packages everything into `target/worldedit-bukkit-6.1.5.jar`

### Dependencies
- All required JARs are in `/lib/` directory
- Spigot 1.8.8: `/lib/spigot-1.8.8.jar`
- WorldEdit 6.1.5: `/lib/worldedit-bukkit-6.1.5.jar`

## Key Implementation Details

**Tab Completion Override**: The main purpose is to disable WorldEdit's tab completion by returning an empty list in `onTabComplete()` method. This prevents server crashes that occurred with the original WorldEdit tab completion system.

**Plugin Configuration**: The custom plugin uses the same configuration structure as the original WorldEdit but with a modified main class path in `plugin.yml`.

## Files Structure

- `/src/main/java/`: Custom Java source code
- `/src/main/resources/plugin.yml`: Plugin manifest with custom main class
- `/src/main/resources/defaults/config.yml`: Default WorldEdit configuration
- `/lib/`: Required JAR dependencies
- `/target/`: Build output directory