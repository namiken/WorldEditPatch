# WorldEdit パッチプロジェクト

このプロジェクトは、サーバークラッシュの問題を修正するためのカスタムMinecraft Bukkit プラグインを作成します。元のWorldEditプラグインを拡張して、WorldEditプラグインによるサーバークラッシュを防ぐために設計されています。

## アーキテクチャ

- **ベースプラグイン**: `com.sk89q.worldedit.bukkit.WorldEditPlugin`を拡張
- **メインクラス**: `com/sk89q/worldedit_custom/bukkit/CustomWorldEditPlugin.java`
- **ビルドプロセス**: MavenとAntを使用して、元のWorldEdit JARを展開し、カスタム修正を加えて再パッケージ化
- **依存関係**: Spigot 1.8.8とWorldEdit-Bukkit 6.1.5（両方とも`/lib/`にシステム依存関係として配置）

## 主な機能

このプロジェクトの主な目的は、WorldEditのタブ補完を無効化することです。`onTabComplete()`メソッドで空のリストを返すことで、元のWorldEditタブ補完システムで発生していたサーバークラッシュを防ぎます。

## ビルド方法

### コンパイル
```bash
mvn clean compile
mvn package
```

### ビルドプロセス
1. `lib/worldedit-bukkit-6.1.5.jar`を出力ディレクトリに展開（plugin.ymlファイルを除く）
2. カスタムJavaコードをコンパイル
3. すべてを`target/worldedit-bukkit-6.1.5.jar`にパッケージ化

## 依存関係

すべての必要なJARファイルは`/lib/`ディレクトリに配置されています：
- Spigot 1.8.8: `/lib/spigot-1.8.8.jar`
- WorldEdit 6.1.5: `/lib/worldedit-bukkit-6.1.5.jar`

## ファイル構造

```
/src/main/java/                           # カスタムJavaソースコード
/src/main/resources/plugin.yml            # カスタムメインクラスを持つプラグインマニフェスト
/src/main/resources/defaults/config.yml   # デフォルトWorldEdit設定
/lib/                                     # 必要なJAR依存関係
/target/                                  # ビルド出力ディレクトリ
```

## 主な実装詳細

**タブ補完のオーバーライド**: 主な目的は、`onTabComplete()`メソッドで空のリストを返すことでWorldEditのタブ補完を無効化することです。これにより、元のWorldEditタブ補完システムで発生していたサーバークラッシュを防ぎます。

**プラグイン設定**: カスタムプラグインは元のWorldEditと同じ設定構造を使用しますが、`plugin.yml`でメインクラスパスが修正されています。

## 使用方法

1. プロジェクトをビルドします：
   ```bash
   mvn clean package
   ```

2. 生成された`target/worldedit-bukkit-6.1.5.jar`をサーバーの`plugins`フォルダにコピーします。

3. サーバーを再起動してプラグインを有効化します。

## 注意

このプラグインは既存のサーバークラッシュ問題を解決するために設計されました。元のWorldEditの機能はそのまま利用できますが、タブ補完は無効化されています。