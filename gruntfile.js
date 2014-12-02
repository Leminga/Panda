module.exports = function (grunt) {

    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        concat: {
            options: {
                separator: "\n" //add a new line after each file
            },
            dist: {
                src: ['public/javascripts/Panda.js',
                    'public/javascripts/RouteProvider.js',
                    'public/javascripts/ForgottenPassword.js',
                    'public/javascripts/RegisterForm.js',
                    'public/javascripts/LoginForm.js',
                    'public/javascripts/*.js'],
                dest: 'public/javascripts/grunt/<%= pkg.name %>.js'

            }
        },
        watch: {
            scripts: {
                files: ['public/javascripts/*.js'],
                tasks: ['dev-watch'],
                options: {
                    interrupt: true
                }
            }
        }
    });

    // Load the plugin that provides the "uglify" task.
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-concat-in-order');
    grunt.registerTask('dev-watch', ['concat:dist']);

    grunt.registerTask('build', ['concat','watch']);


};