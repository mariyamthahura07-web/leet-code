class ThroneInheritance {

    Map<String,List<String>> map = new HashMap<>();
    Set<String> dead = new HashSet<>();
    String king;

    public ThroneInheritance(String kingName) {
        king = kingName;
    }

    public void birth(String p, String c) {
        map.computeIfAbsent(p, k -> new ArrayList<>()).add(c);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        dfs(king, ans);
        return ans;
    }

    void dfs(String s, List<String> ans) {
        if (!dead.contains(s)) ans.add(s);
        if (map.containsKey(s))
            for (String c : map.get(s))
                dfs(c, ans);
    }
}