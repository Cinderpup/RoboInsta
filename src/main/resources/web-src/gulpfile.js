'use strict';

/* do NOT change the order of the pipes as this could cause unwanted effects */
var pkg = require('./package.json'),
    del = require('del'),
    gulp = require('gulp'),
    autoprefixer = require('gulp-autoprefixer'),
    bless = require('gulp-bless'),
    cached = require('gulp-cached'),
    concat = require('gulp-concat'),
    copy = require('gulp-copy'),
    eslint = require('gulp-eslint'),
    htmllint = require('gulp-htmllint'),
    notify = require('gulp-notify'),
    plumber = require('gulp-plumber'),
    uglify = require('gulp-uglify'),
    gUtil = require('gulp-util'),
    fileExists = require('file-exists'),
    rename = require('gulp-rename'),
    gutil = require('gulp-util'),
    fs = require('fs');

var paths = {
    scripts: [
        "asset/js/*",
        "node_modules/gentelella/production/js/**",
        "node_modules/gentelella/build/js/**"
    ],
    css: [
        "asset/css/*",
        "node_modules/gentelella/production/css/**",
        "node_modules/gentelella/build/css/**"
    ],
    img: [
        "images/*",
        "node_modules/gentelella/production/images/**"
    ],
    fonts: ["asset/fonts/*"],
    vendors: [
        "node_modules/gentelella/vendors/**"
    ]
};

// helper functions
function onError(err) {
    gUtil.log('\n', gUtil.colors.bold(gUtil.colors.red('Error ocurred: ') + err.message + ' @ ' + err.fileName + ':' + err.lineNumber), '\n');
    gUtil.beep();
    this.emit('end');
}

// clean folders
gulp.task('clean', function() {
    pkg.clean.forEach(function(path) {
        return del.sync(path, {
            'force': true
        });
    });
});

//  Images
gulp.task('imgbuild', function() {
    return gulp
        .src(paths.img)
        .pipe(gulp.dest('../static/assets/images/'));
});

gulp.task('vendorbuild', function() {
    return gulp
        .src(paths.vendors)
        .pipe(gulp.dest('../static/assets/vendor/'));
});

gulp.task('jsbuild', function() {
    return gulp
        .src(paths.scripts)
        .pipe(gulp.dest('../static/assets/js/'));
});

// CSS
gulp.task('cssbuild', function() {
    return gulp
        .src(paths.css)
        .pipe(gulp.dest('../static/assets/css/'));
});

//FONTS
gulp.task('fontbuild', function() {
    return gulp
        .src(paths.fonts)
        .pipe(gulp.dest('../static/assets/fonts/'));
});

// default task
gulp.task('build', ['clean'], function() {
    gulp.start('imgbuild');
    gulp.start('vendorbuild');
    gulp.start('fontbuild');
    gulp.start('cssbuild');
    gulp.start('jsbuild');
});
