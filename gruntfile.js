module.exports = function (grunt) {

    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        concat: {
            options: {
                separator: "\n" //add a new line after each file
            },
            dist: {
                src: ['bower_components/ngImgCrop/compile/unminified/*.js','client/app.js', 'client/**/*.js'],
                dest: 'public/app.js'

            }

        },
        watch: {
            scripts: {
                files: ['client/**/*'],
                tasks: ['build'],
                options: {
                    interrupt: true
                }
            }
        },
        copy: {
            views: {
                files: [
                    {
                        expand: true,
                        flatten: true,
                        src: ['client/**/*.html', '!client/**/index.html'],
                        dest: 'public/views/'
                    }
                ]
            },
            stylesheets: {
                files: [
                    {expand: true, flatten: true, src: ['client/**/*.css'], dest: 'public/stylesheets/'}
                ]
            },
            images: {
                files: [
                    {expand: true, flatten: true, src: ['client/**/images/*'], dest: 'public/images/'}
                ]
            },
            index: {
                files: [
                    {expand: true, flatten: true, src: ['client/**/index.html'], dest: 'public/'}
                ]
            },
            imgcrop: {
                files: [
                    {expand: true, flatten: true, src: ['bower_components/ngImgCrop/compile/unminified/*.css'], dest: 'public/stylesheets/'}
                ]
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-concat-in-order');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.registerTask('dev-watch', ['watch']);
    grunt.registerTask('build', ['concat', 'copy']);


};