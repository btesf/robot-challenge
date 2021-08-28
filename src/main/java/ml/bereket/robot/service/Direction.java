package ml.bereket.robot.service;

import lombok.Getter;

@Getter
public enum Direction {

    EAST(){
        @Override
        public Direction getLeft() {
            return NORTH;
        }

        @Override
        public Direction getRight() {
            return SOUTH;
        }

        @Override
        public Direction getOpposite() {
            return WEST;
        }
    },

    WEST(){
        @Override
        public Direction getLeft() {
            return SOUTH;
        }

        @Override
        public Direction getRight() {
            return NORTH;
        }

        @Override
        public Direction getOpposite() {
            return EAST;
        }
    },

    NORTH(){
        @Override
        public Direction getLeft() {
            return WEST;
        }

        @Override
        public Direction getRight() {
            return EAST;
        }

        @Override
        public Direction getOpposite() {
            return SOUTH;
        }
    },

    SOUTH(){
        @Override
        public Direction getLeft() {
            return EAST;
        }

        @Override
        public Direction getRight() {
            return WEST;
        }

        @Override
        public Direction getOpposite() {
            return NORTH;
        }
    };

    public abstract Direction getLeft();
    public abstract Direction getRight();
    public abstract Direction getOpposite();
}
