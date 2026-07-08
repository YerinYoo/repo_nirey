from flask import Flask, redirect, render_template, request, url_for

app = Flask(__name__)

todos = []


def next_id():
    return max((todo["id"] for todo in todos), default=0) + 1


@app.route("/", methods=["GET"])
def index():
    return render_template("index.html", todos=todos)


@app.route("/add", methods=["POST"])
def add_todo():
    title = request.form.get("title", "").strip()
    if title:
        todos.append({"id": next_id(), "title": title, "completed": False})
    return redirect(url_for("index"))


@app.route("/toggle/<int:todo_id>", methods=["POST"])
def toggle_todo(todo_id):
    for todo in todos:
        if todo["id"] == todo_id:
            todo["completed"] = not todo["completed"]
            break
    return redirect(url_for("index"))


@app.route("/delete/<int:todo_id>", methods=["POST"])
def delete_todo(todo_id):
    global todos
    todos = [todo for todo in todos if todo["id"] != todo_id]
    return redirect(url_for("index"))


if __name__ == "__main__":
    app.run(debug=True)
