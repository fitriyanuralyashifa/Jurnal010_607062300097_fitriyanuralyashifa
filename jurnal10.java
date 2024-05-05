import java.util.*;

public class jurnal10 {
    private static final char[] vertices = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

    // Representasi graf menggunakan Map, di mana setiap vertex memiliki daftar tetangga
    private static final Map<Character, List<Character>> graph = new HashMap<>();

    static {
        // Inisialisasi graf dengan daftar tetangga untuk setiap vertex
        graph.put('A', Arrays.asList('B', 'D'));
        graph.put('B', Arrays.asList('A', 'E'));
        graph.put('C', Arrays.asList('F', 'I'));
        graph.put('D', Arrays.asList('A', 'E', 'G'));
        graph.put('E', Arrays.asList('B', 'H', 'I'));
        graph.put('F', Arrays.asList('C'));
        graph.put('G', Arrays.asList('D'));
        graph.put('H', Arrays.asList('E', 'I'));
        graph.put('I', Arrays.asList('F', 'C', 'H'));

        // Menambahkan semua vertex ke graf dengan daftar tetangga kosong jika belum ada
        for (char vertex : vertices) {
            graph.putIfAbsent(vertex, new ArrayList<>());
        }
    }

    // Algoritma BFS traversal
    public static void bfsTraversal(char startVertex) {
        boolean[] visited = new boolean[vertices.length];
        Queue<Character> queue = new LinkedList<>();

        queue.add(startVertex);
        visited[startVertex - 'A'] = true;

        while (!queue.isEmpty()) {
            char vertex = queue.poll();
            System.out.print(vertex + " "); // Cetak vertex yang sedang diproses

            // Proses semua tetangga yang belum dikunjungi
            for (char neighbor : graph.get(vertex)) {
                if (!visited[neighbor - 'A']) {
                    queue.add(neighbor);
                    visited[neighbor - 'A'] = true; // Tandai tetangga sebagai sudah dikunjungi
                }
            }
        }
    }

    // Algoritma DFS traversal
    public static void dfsTraversal(char startVertex) {
        boolean[] visited = new boolean[vertices.length];

        dfsHelper(startVertex, visited);
    }

    // Helper function untuk DFS traversal menggunakan rekursi
    private static void dfsHelper(char vertex, boolean[] visited) {
        visited[vertex - 'A'] = true; // Tandai vertex sebagai sudah dikunjungi
        System.out.print(vertex + " "); // Cetak vertex yang sedang diproses

        // Proses semua tetangga yang belum dikunjungi
        for (char neighbor : graph.get(vertex)) {
            if (!visited[neighbor - 'A']) {
                dfsHelper(neighbor, visited); // Panggil rekursif untuk tetangga yang belum dikunjungi
            }
        }
    }

    // Main function untuk menjalankan program
    public static void main(String[] args) {
        System.out.println("BFS Traversal:");
        bfsTraversal('A'); // Memulai BFS traversal dari vertex A

        System.out.println("\nDFS Traversal:");
        dfsTraversal('A'); // Memulai DFS traversal dari vertex A
    }
}
