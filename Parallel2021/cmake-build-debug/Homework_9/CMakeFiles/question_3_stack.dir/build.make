# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2020.3\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2020.3\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = F:\Materials\MyCode\cLion_workSpace\Parallel2021

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = F:\Materials\MyCode\cLion_workSpace\Parallel2021\cmake-build-debug

# Include any dependencies generated for this target.
include Homework_9/CMakeFiles/question_3_stack.dir/depend.make

# Include the progress variables for this target.
include Homework_9/CMakeFiles/question_3_stack.dir/progress.make

# Include the compile flags for this target's objects.
include Homework_9/CMakeFiles/question_3_stack.dir/flags.make

Homework_9/CMakeFiles/question_3_stack.dir/question_3_stack.cpp.obj: Homework_9/CMakeFiles/question_3_stack.dir/flags.make
Homework_9/CMakeFiles/question_3_stack.dir/question_3_stack.cpp.obj: ../Homework_9/question_3_stack.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=F:\Materials\MyCode\cLion_workSpace\Parallel2021\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object Homework_9/CMakeFiles/question_3_stack.dir/question_3_stack.cpp.obj"
	cd /d F:\Materials\MyCode\cLion_workSpace\Parallel2021\cmake-build-debug\Homework_9 && E:\Dev_Software\cpp_compiler\mingw64\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\question_3_stack.dir\question_3_stack.cpp.obj -c F:\Materials\MyCode\cLion_workSpace\Parallel2021\Homework_9\question_3_stack.cpp

Homework_9/CMakeFiles/question_3_stack.dir/question_3_stack.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/question_3_stack.dir/question_3_stack.cpp.i"
	cd /d F:\Materials\MyCode\cLion_workSpace\Parallel2021\cmake-build-debug\Homework_9 && E:\Dev_Software\cpp_compiler\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E F:\Materials\MyCode\cLion_workSpace\Parallel2021\Homework_9\question_3_stack.cpp > CMakeFiles\question_3_stack.dir\question_3_stack.cpp.i

Homework_9/CMakeFiles/question_3_stack.dir/question_3_stack.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/question_3_stack.dir/question_3_stack.cpp.s"
	cd /d F:\Materials\MyCode\cLion_workSpace\Parallel2021\cmake-build-debug\Homework_9 && E:\Dev_Software\cpp_compiler\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S F:\Materials\MyCode\cLion_workSpace\Parallel2021\Homework_9\question_3_stack.cpp -o CMakeFiles\question_3_stack.dir\question_3_stack.cpp.s

# Object files for target question_3_stack
question_3_stack_OBJECTS = \
"CMakeFiles/question_3_stack.dir/question_3_stack.cpp.obj"

# External object files for target question_3_stack
question_3_stack_EXTERNAL_OBJECTS =

Homework_9/question_3_stack.exe: Homework_9/CMakeFiles/question_3_stack.dir/question_3_stack.cpp.obj
Homework_9/question_3_stack.exe: Homework_9/CMakeFiles/question_3_stack.dir/build.make
Homework_9/question_3_stack.exe: Homework_9/CMakeFiles/question_3_stack.dir/linklibs.rsp
Homework_9/question_3_stack.exe: Homework_9/CMakeFiles/question_3_stack.dir/objects1.rsp
Homework_9/question_3_stack.exe: Homework_9/CMakeFiles/question_3_stack.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=F:\Materials\MyCode\cLion_workSpace\Parallel2021\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable question_3_stack.exe"
	cd /d F:\Materials\MyCode\cLion_workSpace\Parallel2021\cmake-build-debug\Homework_9 && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\question_3_stack.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
Homework_9/CMakeFiles/question_3_stack.dir/build: Homework_9/question_3_stack.exe

.PHONY : Homework_9/CMakeFiles/question_3_stack.dir/build

Homework_9/CMakeFiles/question_3_stack.dir/clean:
	cd /d F:\Materials\MyCode\cLion_workSpace\Parallel2021\cmake-build-debug\Homework_9 && $(CMAKE_COMMAND) -P CMakeFiles\question_3_stack.dir\cmake_clean.cmake
.PHONY : Homework_9/CMakeFiles/question_3_stack.dir/clean

Homework_9/CMakeFiles/question_3_stack.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" F:\Materials\MyCode\cLion_workSpace\Parallel2021 F:\Materials\MyCode\cLion_workSpace\Parallel2021\Homework_9 F:\Materials\MyCode\cLion_workSpace\Parallel2021\cmake-build-debug F:\Materials\MyCode\cLion_workSpace\Parallel2021\cmake-build-debug\Homework_9 F:\Materials\MyCode\cLion_workSpace\Parallel2021\cmake-build-debug\Homework_9\CMakeFiles\question_3_stack.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : Homework_9/CMakeFiles/question_3_stack.dir/depend

