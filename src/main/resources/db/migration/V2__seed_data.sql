-- INSERT ROBOTS
INSERT INTO robots (name, description) VALUES
                                           ('Optimus', 'Heavy-Duty Industrial & Commercial Work'),
                                           ('Figure 03', 'Precision HouseHold & Domestic Tasks');

-- INSERT TASKS FOR OPTIMUS
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Heavy Lifting & Loading', 95.00, id FROM robots WHERE name = 'Optimus';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Warehouse Inventory', 85.00, id FROM robots WHERE name = 'Optimus';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Construction Assist', 110.00, id FROM robots WHERE name = 'Optimus';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Outdoor Landscaping', 80.00, id FROM robots WHERE name = 'Optimus';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Equipment Transport', 100.00, id FROM robots WHERE name = 'Optimus';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Loading Dock Support', 90.00, id FROM robots WHERE name = 'Optimus';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Facility Maintenance', 75.00, id FROM robots WHERE name = 'Optimus';

-- INSERT TASKS FOR FIGURE 03
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Laundry- Wash & Fold', 55.00, id FROM robots WHERE name = 'Figure 03';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Dishes & Kitchen Cleanup', 50.00, id FROM robots WHERE name = 'Figure 03';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Vacuuming & Sweeping', 50.00, id FROM robots WHERE name = 'Figure 03';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Grocery Unpack & Organize', 45.00, id FROM robots WHERE name = 'Figure 03';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Surface & Countertop Cleaning', 50.00, id FROM robots WHERE name = 'Figure 03';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Trash & Recycling', 40.00, id FROM robots WHERE name = 'Figure 03';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Bed Making', 45.00, id FROM robots WHERE name = 'Figure 03';
INSERT INTO tasks (name, base_price, robot_id)
SELECT 'Pet Care Assist', 55.00, id FROM robots WHERE name = 'Figure 03';