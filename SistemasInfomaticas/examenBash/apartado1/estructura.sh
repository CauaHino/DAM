#!/bin/bash

touch NOTES.txt

mkdir -p core/rust/physics
cd core/rust/physics/ 
touch engine.rs solver.rs cache.cache

cd ../..
mkdir -p  go/api
mkdir -p go/auth

cd go/api
touch server.go routes.go

cd ../auth
touch login.go tokens.go

