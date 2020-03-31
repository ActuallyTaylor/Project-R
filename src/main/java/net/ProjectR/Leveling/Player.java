package net.ProjectR.Leveling;

public class Player {
    public int fightingLevel;
    public int miningLevel;
    public int explorationLevel;
    public int craftingLevel;
    public int smithingLevel;
    public int farmingLevel;
    public int tradingLevel;
    public int xp;
    public int level;
    public int neededXP;

    public Player() {
        fightingLevel = 1;
        miningLevel = 1;
        explorationLevel = 1;
        craftingLevel = 1;
        smithingLevel = 1;
        farmingLevel = 1;
        tradingLevel = 1;
        xp = 1;
        level = 1;
        neededXP = 1;
    }

    public Player(int f, int m, int e, int c, int s, int fa, int t, int x ,int l, int n) {
        fightingLevel = f;
        miningLevel = m;
        explorationLevel = e;
        craftingLevel = c;
        smithingLevel = s;
        farmingLevel = fa;
        tradingLevel = t;
        xp = x;
        level = l;
        neededXP = n;
    }
}