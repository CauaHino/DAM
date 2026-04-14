#!/bin/bash

cd /home/alumno/examen-dam78/apartado1

mkdir ./core/go/auth/backup/

cd core/rust/physics
touch ../../go/api mirror.rs

cd /home/alumno/examen-dam78/apartado1/core

cp -r ./rust/physics/*.rs ./go/api

mv ../NOTES.txt /home/alumno/examen-dam78/apartado1/core/rust/physics

cd rust/
mv physics physics_old

cp -r ../go/api/*.go ../go/auth/

rm -rf ./physics_old/*.cache

cd ../

rm -r /home/alumno/examen-dam78/apartado1/core/go/api/
