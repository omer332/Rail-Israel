import subprocess

from flask import Flask, request

app = Flask("my_app1")


@app.route("/rail")
def rail_schedule():
    # for regular
    if 'out_format' in request.args:
        out_format = request.args.get('out_format')
        # for web
    else:
        out_format = "html"
    return subprocess.check_output(["java", "-classpath", "bin", "WebData", out_format, request.args.get('origin'),
                                    request.args.get('destination'), request.args.get('hour'),
                                    request.args.get('minutes')])


app.run(port=8005, host="0.0.0.0")
# http://localhost:8005/rail?outformat=html&origin=tel_aviv&destination=beer_sheva&hour=23&minutes=30
