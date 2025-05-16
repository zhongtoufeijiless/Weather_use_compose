# Compose 天气应用

## 项目简介
本项目是一个基于 Jetpack Compose 构建的现代化天气应用，支持城市天气查询、生活指数、未来天气预报等功能。项目采用模块化设计，代码结构清晰，易于扩展和维护。

## 技术栈
- **Jetpack Compose**：声明式 UI 框架，简化界面开发
- **Kotlin**：主力开发语言
- **Hilt**：依赖注入框架，简化依赖管理
- **MVVM 架构**：分离视图与业务逻辑，提升可维护性
- **协程 Flow**：异步数据流处理

## 原型设计
项目原型图和交互流程见 `realProtype/` 目录，主要包括：
- Home.html：主页面原型
- CityManager.html：城市管理页面
- WeatherDetail.html：天气详情页面
- Settings.html：设置页面
- PrototypeNav.html：导航流程

部分原型参考图如下：

![原型参考图](protype/参考图片.png)

## 目录结构
- `app/`：主应用代码
- `realProtype/`：最终原型 HTML 文件
- `protype/`：原型设计文档及图片
- `steps/`：开发过程记录

## 如何运行
1. 克隆本仓库到本地
2. 使用 Android Studio (建议 Arctic Fox 及以上) 打开项目
3. 同步 Gradle 依赖（建议配置国内镜像加速）
4. 运行 `app` 模块即可体验 Compose 天气应用

---

# Compose Weather App (English)

## Introduction
This project is a modern weather app built with Jetpack Compose, supporting city weather query, life index, and future forecast. The codebase is modular and easy to maintain.

## Tech Stack
- **Jetpack Compose**: Declarative UI
- **Kotlin**: Main language
- **Hilt**: Dependency injection
- **MVVM**: Architecture pattern
- **Coroutines Flow**: Async data stream

## Prototypes
See `realProtype/` for HTML prototypes:
- Home.html: Home page
- CityManager.html: City manager
- WeatherDetail.html: Weather detail
- Settings.html: Settings
- PrototypeNav.html: Navigation

Sample prototype image:

![Prototype Reference](protype/参考图片.png)

## Structure
- `app/`: Main code
- `realProtype/`: Final HTML prototypes
- `protype/`: Design docs & images
- `steps/`: Dev notes

## How to Run
1. Clone this repo
2. Open with Android Studio
3. Sync Gradle (use China mirror if needed)
4. Run `app` module
