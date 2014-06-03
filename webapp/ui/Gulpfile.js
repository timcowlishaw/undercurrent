var gulp       = require("gulp");
var browserify = require("gulp-browserify");
var cssmin     = require("gulp-cssmin");
var connect    = require("gulp-connect");
var concat     = require('gulp-concat');
var watch      = require("gulp-watch");

var srcDir      = "src/";
var destDir     = "dist/";
var htmlSrc     = srcDir + "**/*.html";
var imageSrc    = srcDir + "img/**/*";
var imageDest   = destDir + "img/";
var jsSrc       = srcDir + "js/application.js";
var jsDest      = destDir + "js/";
var cssSrc      = srcDir + "css/**/*.css";
var cssDest     = destDir + "css/";
var cssDestFile = "styles.css";
var watchFiles  = srcDir + "**/*";
var watchTasks  = ["default"];

gulp.task("copy:html", function() {
  gulp.src(htmlSrc).pipe(gulp.dest(destDir));
});


gulp.task("copy:images", function() {
  gulp.src(imageSrc).pipe(gulp.dest(imageDest));
});


gulp.task("browserify", function() {
  gulp.src(jsSrc)
    .pipe(browserify({
      debug: true,
      transform: ['node-underscorify']
    }))
    .pipe(gulp.dest(jsDest));
});


gulp.task("cssmin", function() {
  gulp.src(cssSrc)
    .pipe(cssmin())
    .pipe(concat(cssDestFile))
    .pipe(gulp.dest(cssDest));
});

gulp.task("server", function() {
  connect.server({
    port: process.env.UI_PORT || 9001,
    root: destDir,
    livereload: true
  });
});

gulp.task("watch", function() {
  gulp.src(watchFiles)
    .pipe(watch(function(files) {
      gulp.start.apply(gulp, watchTasks);
    }));
});

gulp.task("default", ["copy:html", "copy:images", "browserify", "cssmin"]);
gulp.task('develop', ['server', 'watch']);
