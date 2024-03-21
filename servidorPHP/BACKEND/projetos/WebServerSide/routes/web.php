<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
})-> name('home.welcome');

Route::get('/hello/{name}', function ($name) {
    return '<h2>Ola ' . $name . '</h2>';
})-> name('home.hellow');

Route::get('/hello', function () {
    return view('hello');
})-> name('home.hello');

Route::get('/home', function () {
    return view('home.index');
})-> name('home');

Route::get('/users', function() {
    return view('users.users_all');
}) -> name('users.all');

Route::get('/user/{id}', function($id) {
    return view('users.user_profile');
}) -> name('user.profile');

Route::fallback(function () {
    return view('errors.fallback');
});
