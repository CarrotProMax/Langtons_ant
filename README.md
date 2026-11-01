# Langton's Ant · 兰顿蚂蚁

[中文](#中文) · [English](#english)

一个计算机新手心血来潮、**古法手搓**的兰顿蚂蚁实现。

A hand-written Langton's Ant by a computer science beginner, built on a whim.

---

## 中文

### 缘起

2026 年 10 月 31 日晚上，刷到一个讲兰顿蚂蚁的视频，看得手痒，于是自己手搓一个实现。11月1日下午，用一个下午的时间把它手搓了出来。

规则简单到可以一句话说完：蚂蚁站在格子上，白格右转、黑格左转，落地之后翻转脚下这一格的颜色，然后往前走一格。就这么两条规则，却能在跑了几万步之后自己搭出一条高速公路。

### 关于这份代码

整个项目只有四个类，纯 Java、零依赖、没有构建工具，全部是自己一个字母一个字母敲出来的。写完之后花了十几分钟补注释——不然过几天连自己都看不懂了（乐）。

唯一没能亲自搞定的地方是 `HashMap`：为什么同样的坐标存进去就取不出来？后来问了 AI 才弄明白，原因是没有重写 `hashCode()` 和 `equals()`，于是 `Object` 默认的"认身份"语义把相同坐标当成了不同的 key。这两个方法是照着理解自己写回去的。

> 用蓝色大肥鱼直接生成，速度会快得多。但先在大脑里把结构想清楚、再完全按照自己的想法手搓出来，这种感觉还是很爽的。

### 运行

需要 JDK（项目在 JDK 25 语言级别下编写）。

```bash
cd src
javac *.java
java Main
```

- 蚂蚁默认走 `50000` 步，改 `Main` 里循环的边界就行；
- 每一步都会刷新 50×50 的终端画面，`Thread.sleep(1)` 控制快慢；
- 想跑得快一点，就把 `sleep` 去掉。

### 项目结构

| 文件 | 作用 |
|---|---|
| `Main.java` | 入口：主循环、格子地图、终端绘制 |
| `AntMove.java` | 蚂蚁：坐标、朝向、前进与左右转 |
| `Coordinates.java` | 坐标：X/Y，以及作为 `HashMap` key 所需的 `hashCode` / `equals` |
| `BlockStates.java` | 格子状态：黑白两色，可翻转 |

### 最后

这是一个练手项目，代码风格很"原生态"：中文注释、大写的字段名、手写的 getter/setter，都保留着。

但它是完整的、能跑的，而且每一行都是自己想明白才写下去的。

**规则只有两条，剩下的交给时间。**

---

## English

### How it started

On the evening of October 31, 2026, I stumbled on a video about Langton's Ant and immediately wanted to build one myself. The next afternoon (November 1) I sat down and typed the whole thing out by hand.

The rule is small enough to fit in one sentence: an ant stands on a cell — on white it turns right, on black it turns left, then it flips the color of the cell it is standing on and moves forward one square. Two rules, and after a few tens of thousands of steps it builds itself a highway.

### About this code

Four classes, plain Java, zero dependencies, no build tool — every character typed by hand. Afterwards I spent a few minutes adding comments, otherwise I wouldn't be able to read my own code in a week.

The one thing I couldn't figure out on my own was `HashMap`: why couldn't I get back a cell I had just stored at the same coordinates? I asked an AI, and the answer was that I hadn't overridden `hashCode()` and `equals()`, so `Object`'s default "identity" semantics treated equal coordinates as different keys. I wrote both methods back myself once I understood why.

> Letting the blue whale AI generate it would have been much faster. But thinking the structure through in your own head first, then writing it exactly the way you imagined — that feels great.

### Run

Requires a JDK (written at JDK 25 language level).

```bash
cd src
javac *.java
java Main
```

- The ant walks `50000` steps by default — just change the loop bound in `Main`;
- The 50×50 terminal view refreshes every step, with `Thread.sleep(1)` setting the pace;
- Remove the `sleep` if you want it to run faster.

### Layout

| File | What it does |
|---|---|
| `Main.java` | Entry point: main loop, cell map, terminal rendering |
| `AntMove.java` | The ant: position, heading, forward/left/right |
| `Coordinates.java` | A coordinate: X/Y, plus the `hashCode` / `equals` it needs as a `HashMap` key |
| `BlockStates.java` | Cell state: black or white, flippable |

### Finally

This is a practice project with a very "raw" style: Chinese comments, capitalized field names, hand-written getters and setters — all kept as they are.

But it is complete, it runs, and every line is there because I worked it out myself.

**Two rules, and the rest is just time.**
