'use strict';
var gulp = require('gulp');
var liferayThemeTasks = require('liferay-theme-tasks');
liferayThemeTasks.registerTasks({
	gulp: gulp
});
/*
liferayThemeTasks.registerTasks({
	gulp: gulp,
    hookFn: function(gulp) {
        gulp.hook('after:build', function(done) {
            gulp.src('./node_modules/moment/min/momen1t.min.js')
                .pipe(gulp.dest('./build/js'))
                .on('end', done);

        });
    }
});
*/
