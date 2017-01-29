//println "ls -l".execute().text

//println "groovy -v".execute().text

def log(x, base = 10) {
    Math.log(x) / Math.log(base)
}

println log(1024)
println log(1024, 10)
println log(1024, 2)