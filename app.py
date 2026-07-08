from flask import Flask, redirect, render_template, request, url_for

app = Flask(__name__)

todos = []


def next_id():
    return max((todo["id"] for todo in todos), default=0) + 1


@app.route("/", methods=["GET"])
def index():
    filter_mode = request.args.get("filter", "")
    completed_only = filter_mode == "completed"
    visible_todos = [todo for todo in todos if todo["completed"]] if completed_only else todos
    return render_template("index.html", todos=visible_todos, completed_only=completed_only)


def redirect_to_index(filter_mode: str):
    return redirect(url_for("index", filter=filter_mode) if filter_mode == "completed" else url_for("index"))


@app.route("/add", methods=["POST"])
def add_todo():
    title = request.form.get("title", "").strip()
    filter_mode = request.form.get("filter", "")
    if title:
        todos.append({"id": next_id(), "title": title, "completed": False})
    return redirect_to_index(filter_mode)


@app.route("/toggle/<int:todo_id>", methods=["POST"])
def toggle_todo(todo_id):
    filter_mode = request.form.get("filter", "")
    for todo in todos:
        if todo["id"] == todo_id:
            todo["completed"] = not todo["completed"]
            break
    return redirect_to_index(filter_mode)


@app.route("/delete/<int:todo_id>", methods=["POST"])
def delete_todo(todo_id):
    filter_mode = request.form.get("filter", "")
    global todos
    todos = [todo for todo in todos if todo["id"] != todo_id]
    return redirect_to_index(filter_mode)


if __name__ == "__main__":
    app.run(debug=True)
