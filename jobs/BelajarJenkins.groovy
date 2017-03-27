String app = "Btech"

folder("${app}") {
  description "ini adalah deskripsi bro"
}

job("${app}/BuildNPM") {
    description "Coba build web npm"
    logRotator {
        daysToKeep(7)
        numToKeep(10)
    }
    scm {
        git {
            remote {
                url('https://github.com/tuanpembual/blankon-linux-static-web.git')
            }
            branch('master')
        }
    }
    triggers {
        scm('H/2 * * * *')
    } 

    steps {
     	shell('''npm install
npm run build
tar -czvf dist.tar.gz dist
echo "sukses"''')   
    }
    publishers{
	archiveArtifacts {
            pattern("dist.tar.gz")
            onlyIfSuccessful()
        }
    }
}

    Contact GitHub API Training Shop Blog About 


