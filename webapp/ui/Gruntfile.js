module.exports = function(grunt) {
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    browserify: {
      'dist/js/application.js': ['src/js/application.js']
    },
    cssmin: {
      combine: {
        'dist/css/styles.css': ['src/css/styles.css']
      }
    },
    copy: {
      html: {
        src:  "src/index.html",
        dest: "dist/index.html"
      },
      images : {
        expand : true,
        cwd: "src/img",
        src: "**",
        dest: "dist/img/",
        flatten: false,
      }
    },
    connect: {
      server: {
        options: {
          port: process.env.UI_PORT || 9001,
          base: 'dist/'
        }
      }
    },
    watch: {
      files: ["src/**/*"],
      tasks: ["default"]
    }
  });
  grunt.loadNpmTasks('grunt-browserify');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-contrib-connect');
  grunt.registerTask('default', ['copy:html', 'copy:images', 'browserify', 'cssmin'])
  grunt.registerTask("develop", ["connect", "watch"])
}
