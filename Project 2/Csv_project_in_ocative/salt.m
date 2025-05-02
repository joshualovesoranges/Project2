function [salted_y] = salt(y)
    salted_y = zeros(1,1001);% Generate an empty array
    salt_strength = 100000;
    salt = (rand(size(y)) - 0.5) * 2 * salt_strength;  % Generates the salt from -100000 to 100000
    salted_y = y + salt;    % Add salt to the original array y
end

