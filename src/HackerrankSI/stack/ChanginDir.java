package HackerrankSI.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class ChanginDir {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {

			int tcc = Integer.parseInt(br.readLine());

			Stack<String> st = new Stack<>();
			for (int tt = 0; tt < tcc; tt++) {
				String cmd = br.readLine().trim();

				if (cmd.equals("pwd")) {

					StringBuilder sb = new StringBuilder();
					sb.append("/");
					if (st.size() == 1) {
						sb.append(st.peek());
						sb.append("/");
					} else {
						int k = 0;
						if(!st.isEmpty() && (st.get(0).equals("..") || st.get(0).isEmpty()))
							k = 1;
						for (int i = k; i < st.size(); i++) {

							sb.append(st.get(i).trim());
							sb.append("/");

						}

					}

					sb.append("\n");
					out.write(sb.toString());

				} else {

					String[] cm = cmd.split(" ");
					String[] paths = cm[1].split("/");

					if (!cm[1].equals("..") && !cm[1].equals(".")) {

						if (cm[1].charAt(0) == '/') {
							st = new Stack<>();
						}
					}
					 //System.out.println("paths: " + Arrays.toString(paths));
					for (String p : paths) {

						if (p.equals("..")) {

							if (!st.isEmpty())
								st.pop();
						} else if (!p.equals(".")) {
							st.push(p);
						}
					}
				}
			}
			out.write("\n");

		}

		out.close();
	}
}
